grammar ValidaScript;

prog: start;

start: start funcao
     | funcao
     ;

funcao: 'Ler ficheiro' PONTO_VIRGULA possivel_id=INTEIRO PONTO_VIRGULA ficheiro_script=ficheiro   #lerFicheiro
      | expressao #calcularValor
      ;

expressao: //calculosMatematicos  #express
         nameVar '->' calculosMatematicos   #atribuir
         ;

calculosMatematicos: left=param sinal=MULT_DIV right=param    #multiDiv
                   | left=param sinal=SOMA_SUB right=param    #somaSub
                   | '(' calculosMatematicos ')'                #parenteses
                   ;

param: nameVar  #variavel
     | INTEIRO  #proprioValor
     ;

nameVar: '#' PALAVRA '#';

ficheiro: path XML
        ;

path: path BARRA PALAVRA
    | PALAVRA
    ;

/*--------------------------------FILE--------------------------------*/

progFile: '<File>' startFile '</File>' //| EOF
        ;

startFile: startFile '<Produto>' infoProduto '</Produto>'   //#informacaoProduto
         | startFile '<Cliente>' infoCliente '</Cliente>'   //#informcacaoCliente
         |  //#vazio
         ;

infoProduto: '<Codigo>'  codigo=INTEIRO  '</Codigo>' '<Preco>'  preco=INTEIRO  '</Preco>' '<Categoria>'   categoria=PALAVRA  '</Categoria>'
           | '<Codigo>'  codigo=INTEIRO  '</Codigo>' '<Preco>'  preco=DOUBLE  '</Preco>' '<Categoria>'   categoria=PALAVRA  '</Categoria>'
           |
           ;

infoCliente: '<Numero>' numero=INTEIRO '</Numero>' '<Escalao>' escalao=PALAVRA '</Escalao>'
           |
           ;


SOMA_SUB: '+'
        | '-';
MULT_DIV: '*'
        | '/'
        ;
SOMA: '+';
SUBTRACAO: '-';
MULT: '*';
BARRA: '/' ;
INTEIRO: [0-9]+;
DOUBLE: [0-9]+('.'[0-9]+)?;
PONTO_VIRGULA: ';';
PALAVRA: [A-Za-z0-9]+;
XML: '.xml';
WS:[ \t\r\n]+->skip; //ignora espaços, tabs