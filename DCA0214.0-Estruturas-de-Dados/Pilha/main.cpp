#include <iostream>
#include "pilha.h"
using namespace std;

int main()
{
    Pilha *p = new Pilha(9);
    p->inserir(10);
    p->inserir(11);

    p->remover();
    No *aux = p->topo;
    while(aux != 0){
       cout<<aux->conteudo<<endl;
       aux = aux->prox;
    }
    return 0;
}
