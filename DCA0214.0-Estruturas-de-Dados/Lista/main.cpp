#include <iostream>
#include "lista.h"
using namespace std;

int main()
{
    Lista *l = new Lista(21);

    l->inserirInicio(20);
    l->inserirInicio(19);
    l->inserirInicio(18);
    l->inserirInicio(17);
    l->inserirInicio(16);
    l->inserirInicio(15);

    No *aux = l->head;
    while(aux != 0){
        cout<<aux->conteudo<<endl;
        aux = aux->prox;
    }
    return 0;
}
