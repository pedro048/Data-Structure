#ifndef NOCANDIDATO_H_INCLUDED
#define NOCANDIDATO_H_INCLUDED
#include <cstring>
#include <sstream>
#include "Candidato.h"

using namespace std;

class NoCandidato{
public:
    NoCandidato *next;
    Candidato *conteudo;

    NoCandidato(Candidato *p, NoCandidato *prox);
    string toString();
};

NoCandidato::NoCandidato(Candidato *p, NoCandidato *prox){
    next = prox;
    conteudo = p;
}
string NoCandidato::toString(){
    stringstream stream;
    NoCandidato *aux = this;
    while(aux != NULL){
        stream<<aux->conteudo->sobrenome<<" "<<aux->conteudo->nome<<" "<<aux->conteudo->nota<<" -> ";
        //stream<<next->conteudo->sobrenome<<" "<<next->conteudo->nome<<" "<<next->conteudo->nota<<" ->";
        aux = aux->next;
    }
    stream<<"0";
    return stream.str();
}

#endif // NOCANDIDATO_H_INCLUDED
