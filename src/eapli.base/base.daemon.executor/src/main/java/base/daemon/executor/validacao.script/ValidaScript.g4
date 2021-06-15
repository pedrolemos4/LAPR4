grammar ValidaScript;

prog: start;

start: script
     |
     ;

script: instrucao
      //| instrucao_calculo
      ;

instrucao: instrucao funcao
         | funcao
         ;

funcao: 'Ler ficheiro' PONTO_VIRGULA possivel_id=inteiro PONTO_VIRGULA ficheiro_script=ficheiro  #lerFicheiro
      ;

inteiro: INTEIRO
        ;

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


INTEIRO: [0-9]+;
DOUBLE: [0-9]+('.'[0-9]+)?;
PONTO_VIRGULA: ';';
BARRA: '/' ;
PALAVRA: [A-Za-z0-9]+;
XML: '.xml';
WS:[ \t\r\n]+->skip; //ignora espaços, tabs e mudanças de linha