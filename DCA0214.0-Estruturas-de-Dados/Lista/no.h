#ifndef NO_H
#define NO_H

#endif // NO_H

class No{
public:
    int conteudo;
    No *prox;

    No(int valor);
};
No::No(int valor){
    conteudo = valor;
    this->prox = 0;
}
