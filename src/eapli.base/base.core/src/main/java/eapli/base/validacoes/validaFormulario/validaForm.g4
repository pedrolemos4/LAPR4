grammar validaForm;

regra: TITULO PV PR atributo PRD #valido
| TITULO #invalido
| #vazio
;

atributo: atributo var=nome? PV label=STRING PV des=desc PV tp=TIPO_DADOS PV obr=OBRIGATORIO #valido2
| STRING #invalido2
| TIPO_DADOS #invalido2
| OBRIGATORIO #invalido2
| #vazio1
;

nome: STRING #validoString
| INTEGER #validoInteger
| DATA #validoData
//| BOOLEAN #validoBoolean
;

desc: (STRING)* #validoDesc
;

PR:'[';
PRD:']';
PV:';';
TITULO:[A-Z][a-z]+[0-9]+;
STRING:[A-Z][a-z]+;
INTEGER:[0-9]|[1-9][0-9]+;
DATA:[0-9][0-9][0-9][0-9]'/'('0'[1-9]|'1'[0-2])'/'('0'[1-9]|[1-2][0-9]|'3'[0-1]);
TIPO_DADOS:'INTEGER' | 'STRING' | 'BOOLEAN' | 'DATA';
OBRIGATORIO:'OBRIGATORIO' | 'OPCIONAL';
//EXPRESSAO_REGULAR:[A-Z][a-z]+{1,30};

WS:[ \r\n]+->skip; //ignora espaços, tabs e mudanças de linha