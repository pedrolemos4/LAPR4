grammar validarFormulario;

regra: ID PV TITULO PV atributo #valido
| TITULO #invalido
| #vazio
;

atributo: atributo NOME_VAR PV LABEL PV #valido2
| NOME_VAR #invalido2
| LABEL #invalido2
| #vazio2
;

ID:[0-9]|[1-9][0-9]+;
PV:';';
TITULO:[A-Z][a-z]+[0-9]*{1,50};
NOME_VAR:[A-Z][a-z]+{1,30};
LABEL:[A-Z][a-z]+{1,30};

WS:[ \t\r\n]+->skip; //ignora espaços, tabs e mudanças de linha