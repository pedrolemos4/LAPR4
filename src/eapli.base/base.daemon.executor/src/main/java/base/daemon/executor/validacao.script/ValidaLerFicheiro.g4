grammar ValidaLerFicheiro;

prog: '<File>' start '</File>' //| EOF
    ;

start: start '<Produto>' infoProduto '</Produto>'
     | start '<Cliente>' infoCliente '</Cliente>'
     |
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
PALAVRA: [A-Za-z0-9]+;

S1: '<';
S2: '>';
BARRA_TERMINAL: '/';
WS:[ \t\r\n]+->skip; //ignora espaços, tabs e mudanças de linha