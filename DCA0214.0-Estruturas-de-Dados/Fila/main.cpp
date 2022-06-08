#include <iostream>
#include "fila.h"
using namespace std;

int main()
{
    Fila *f = new Fila(2);
    f->inserir(4);
    f->inserir(6);
    f->remover();
    No *aux = f->inicio;
    while(aux != 0){
        cout<<aux->conteudo<<endl;
        aux = aux->prox;
    }

    return 0;
}
