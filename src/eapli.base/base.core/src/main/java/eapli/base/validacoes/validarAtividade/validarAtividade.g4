grammar validarAtividade;

regra: atv_manu #atvManual
| atv_auto #atvAuto
| #vazio
;

atv_manu : DATA PV ESTADO PV TIPO PV (COLAB|EQUIPA) PV DECISAO PV COMENTARIO PV FORM #valido
| DATA #invalido
| ESTADO #invalido
| TIPO #invalido
| COLAB #invalido
| EQUIPA #invalido
| DECISAO #invalido
| COMENTARIO #invalido
| FORM #invalido
| #vazio2
;

atv_auto : DATA PV ESTADO PV TIPO #valido2
| DATA #invalido2
| ESTADO #invalido2
| TIPO #invalido2
| #vazio3
;

PV:';';
DATA:'202'[0-9]'-'[0-9]|[1][0-2]'-'([0-9]|[1][0-9]|[2][0-9]|[3][0-1]);
ESTADO:'pendente'|'completo';
TIPO:'realizacao'|'aprovacao';
COLAB:[0-9]+;
EQUIPA:[A-Z|a-z]+[0-9]+;
DECISAO:[A-Z|a-z]+;
COMENTARIO:[A-Z|a-z]+;
FORM:[0-9]|[1-9][0-9]+;

WS:[ \t\r\n]+->skip; //ignora espaços, tabs e mudanças de linha