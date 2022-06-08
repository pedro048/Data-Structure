#ifndef FILA_H
#define FILA_H

#endif // FILA_H
#include "no.h"

class Fila{
public:
    No *inicio;
    No *fim;

    Fila();
    Fila(int valor);
    bool vazia();
    void inserir(int valor);
    void remover();
};
Fila::Fila(){
    No *n = new No(0);
    fim = n;
    inicio = fim;
}
Fila::Fila(int valor){
    No *n = new No(valor);
    fim = n;
    inicio = fim;
}
bool Fila::vazia(){
    return (inicio==0);
}
void Fila::inserir(int valor){
    No *n = new No(valor);
    if(vazia()){
        fim = n;
        inicio = fim;
    }else{
        fim->prox = n;
        fim = n;
    }
}
void Fila::remover(){
    No *aux = inicio;
    inicio = inicio->prox;
    delete(aux);
}
