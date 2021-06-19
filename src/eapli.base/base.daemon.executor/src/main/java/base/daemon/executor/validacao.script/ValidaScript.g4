grammar ValidaScript;

prog: start;

start: start funcao
     | funcao
     ;

funcao: 'Ler ficheiro' PONTO_VIRGULA possivel_id=INTEIRO PONTO_VIRGULA ficheiro_script=ficheiro PONTO_VIRGULA valor=valor_pretendido  #lerFicheiro
      | 'Send Email' PONTO_VIRGULA emailColab=EMAIL PONTO_VIRGULA tipoCliente=PALAVRA #enviarEmailProduto
      | 'Send Email' PONTO_VIRGULA emailColab=EMAIL PONTO_VIRGULA decisao=frase PONTO_VIRGULA desconto=percentagem #enviarEmailFormulario
      | expressao #calcularValor
      //| calcPrecoTotal #calcular_preco_total
      | 'if ' expressao_a_verificar ' then:' aplicar_desconto temElse=else1? 'end if;' #aplicarDesconto
      | 'Valor total' #calcularDescontoEPreco
      //| calcPrecoFinal #calcular_preco_final
      ;

else1: 'else' aplicar_desconto
     ;

expressao_a_verificar: leftPortion=param sinal=SINAL_BOOLEANO rightPortion=param
                     | leftPortionCat='CATEGORIA' sinal=('=='|'!=') rightPortionCat=PALAVRA
                     ;

aplicar_desconto: 'Aplicar Desconto->' valorDesconto=param //meter
                //| var=nameVar '->' param1=nameVar sinal=('+'|'*') param1=nameVar
                ;

//calcPrecoTotal: var=nameVar '->QUANT->' quantidade=INTEIRO
//             ;

//calcPrecoFinal: var=nameVar '->DESCONTO->' desconto=DOUBLE
                          //;

expressao: nameVar '->' calculosMatematicos   #atribuir
         ;

calculosMatematicos: left=param sinal=MULT_DIV right=param    #multiDiv
                   | left=param sinal=SOMA_SUB right=param    #somaSub
                   | '(' calculosMatematicos ')'                #parenteses
                   | INTEIRO                                  #atribuiInteiro
                   | DOUBLE                                   #atribuiDouble
                   ;

param: nameVar  #variavel
     | INTEIRO  #proprioValor
     | DOUBLE   #valorDouble
     ;

valor_pretendido: ESCALAO
                | CATEGORIA
                | PRECO
                |
                ;

percentagem: DOUBLE '%'
           | INTEIRO '%'
           ;

frase: frase PALAVRA ' '
    | PALAVRA
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
SINAL_BOOLEANO: '>'|'<'|'<='|'>='|'=';
SOMA: '+';
SUBTRACAO: '-';
MULT: '*';
BARRA: '/' ;
ESCALAO: 'Escalao';
PRECO: 'Preco';
CATEGORIA: 'Categoria';
INTEIRO: [0-9]+;
DOUBLE: [0-9]+('.'[0-9]+)?;
PONTO_VIRGULA: ';';
PALAVRA: [A-Za-z0-9]+;
EMAIL: [A-Za-z0-9]+('@gmail.com'|'@hotmail.com'|'@isep.ipp.pt');
XML: '.xml';
WS:[ \t\r\n]+->skip; //ignora espaços, tabs