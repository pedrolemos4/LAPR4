grammar validaForm;

regra: TITULO PV atributo #valido
| TITULO #invalido
| #vazio
;

atributo: var=nome PV label=STRING PV des=STRING* PV tp=TIPO_DADOS PV obr=OBRIGATORIO (PV atributo)* #valido2
| STRING #invalido2
| TIPO_DADOS #invalido2
| OBRIGATORIO #invalido2
| #vazio1
;

nome: STRING #validoString
| DIGITO+ #validoInteger
| ano=ANO BARRA mes=(DOIS_DIGITOS|DIGITO) BARRA dia=(DOIS_DIGITOS|DIGITO) #validoData
| BOOLEAN #validoBoolean
| #nomeVazio
//| BOOLEAN #validoBoolean
;

BARRA:'/';
PV:';';
ANO:[0-9][0-9][0-9][0-9];
DOIS_DIGITOS:[0-9][0-9];
DIGITO:[0-9];
TITULO:[A-Z][a-z]+[0-9]+;
STRING:[A-Z][a-z]+;
BOOLEAN:'true' | 'false';
TIPO_DADOS:'INTEGER' | 'STRING' | 'BOOLEAN' | 'DATA';
OBRIGATORIO:'OBRIGATORIO' | 'OPCIONAL';
//EXPRESSAO_REGULAR:[A-Z][a-z]+{1,30};

WS:[ \t\r\n]+->skip; //ignora espaços, tabs e mudanças de linha