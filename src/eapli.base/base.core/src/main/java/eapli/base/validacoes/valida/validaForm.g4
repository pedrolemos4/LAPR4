grammar validaForm;

regra: INTEGER PV TITULO PV atributo #valido
| TITULO #invalido
| #vazio
;

atributo: atributo var=nome PV label=LABEL? PV des=DESCRICAO_AJUDA? PV tp=TIPO_DADOS PV obr=OBRIGATORIO #valido2
| LABEL #invalido2
| DESCRICAO_AJUDA #invalido2
| TIPO_DADOS #invalido2
| OBRIGATORIO #invalido2
| #vazio1
;

nome: STRING #validoString
| INTEGER #validoInteger
| DATA #validoData
| BOOLEAN #validoBoolean
| #vazio2
;

//ID:[0-9]|[1-9][0-9]+;
PV:';';
TITULO:[A-Z][a-z]+[0-9]+{1,50};
LABEL:[a-z]+{1,30};
STRING:[A-Z][a-z]+;
INTEGER:[0-9]|[1-9][0-9]+;
DATA:[0-9][0-9][0-9][0-9]'/'('0'[1-9]|'1'[0-2])'/'('0'[1-9]|[1-2][0-9]|'3'[0-1]);
//NOME_VAR:(|ID|){1,30}; //nomes, numeros, data e falta boolean
DESCRICAO_AJUDA:[a-z]+[0-9]+{1,30};
TIPO_DADOS:'INTEGER' | 'STRING' | 'BOOLEAN' | 'DATA';
OBRIGATORIO:'OBRIGATORIO' | 'OPCIONAL';
//EXPRESSAO_REGULAR:[A-Z][a-z]+{1,30};

WS:[ \t\r\n]+->skip; //ignora espaços, tabs e mudanças de linha