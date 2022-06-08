#ifndef LISTA_H
#define LISTA_H

#endif // LISTA_H

#include <iostream>
#include "no.h"

using namespace std;

class Lista{
public:
    No *head;
    No *tail;

    Lista();
    Lista(int valor);
    bool vazia();
    void inserirInicio(int valor);
    void inserirFinal(int valor);
    bool remover(int valor);
    void esvaziar();
    void concatenar(Lista *l);
};
Lista::Lista(){
    No *n = new No(0);
    head = n;
    tail = head;
}
Lista::Lista(int valor){
    No *n = new No(valor);
    head = n;
    tail = head;
}
bool Lista::vazia(){
    return (head == 0);
}
void Lista::inserirInicio(int valor){
    No *novoNo = new No(valor);
    if(vazia()){
        head = novoNo;
        tail = head;
    }else{
        novoNo->prox = head;
        head = novoNo;
    }
}
void Lista::inserirFinal(int valor){
    No *novoNo = new No(valor);
    if(vazia()){
        tail = novoNo;
        head = tail;
    }else{
        tail->prox = novoNo;
        tail = novoNo;
    }
}
bool Lista::remover(int valor){
    No *aux = head;
    No *apagar;
    if(head->conteudo == valor){
        head = head->prox;
        delete(aux);
    }else{
        while(aux->prox != 0){
            if(aux->prox->conteudo == valor){
                apagar = aux->prox;
                aux->prox = aux->prox->prox;
                delete(apagar);
                return true;
            }
            aux = aux->prox;
        }
        return false;
    }
}
void Lista::esvaziar(){
    No *aux = head;
    No *apagar = head;
    while(aux->prox != 0){
        delete(apagar);
        aux = aux->prox;
        apagar = aux;
    }
    delete(tail);

}
void Lista::concatenar(Lista *l){
    No *aux = head;
    while(aux->prox != 0){
        aux = aux->prox;
    }
    aux->prox = l->head;
}

