#ifndef PILHA_H
#define PILHA_H

#endif // PILHA_H
#include "no.h"

class Pilha{ // FILO
public:
    No *topo;
    Pilha();
    Pilha(int valor);
    bool vazia();
    void inserir(int valor);
    void remover();
};
Pilha::Pilha(){
    No *n = new No(0);
    topo = n;
}
Pilha::Pilha(int valor){
    No *n = new No(valor);
    topo = n;
}
bool Pilha::vazia(){
    return (topo==0);
}
void Pilha::inserir(int valor){
    No *n = new No(valor);
    if(vazia()){
        topo = n;
    }else{
        n->prox = topo;
        topo = n;
    }
}
void Pilha::remover(){
    No *aux = topo;
    topo = topo->prox;
    delete(aux);
}
