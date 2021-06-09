grammar validarFormulario;

regra: ID PV TITULO PV atributo #valido
| TITULO #invalido
| #vazio
;

atributo: atributo NOME_VAR PV LABEL PV DESCRICAO_AJUDA PV TIPO_DADOS PV OBRIGATORIO#valido2
| NOME_VAR #invalido2
| LABEL #invalido2
| DESCRICAO_AJUDA #invalido2
| TIPO_DADOS #invalido2
| OBRIGATORIO #invalido2
| #vazio2
;

ID:[0-9]|[1-9][0-9]+;
PV:';';
TITULO:[A-Z][a-z]+[0-9]*{1,50};
LABEL:[A-Z][a-z]+{1,30};
NOME_VAR:([A-Z][a-z]+|[0-9]|[1-9][0-9]+){1,30};
DESCRICAO_AJUDA:[A-Z][a-z]+{1,30};
TIPO_DADOS:'INTEGER' | 'STRING' | 'BOOLEAN' | 'DATA';
OBRIGATORIO:'true' | 'false';
EXPRESSAO_REGULAR:[A-Z][a-z]+{1,30};

WS:[ \t\r\n]+->skip; //ignora espaços, tabs e mudanças de linha