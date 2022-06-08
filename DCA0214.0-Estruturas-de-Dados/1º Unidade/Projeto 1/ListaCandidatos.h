#ifndef LISTACANDIDATOS_H_INCLUDED
#define LISTACANDIDATOS_H_INCLUDED
#include <cstring>
#include <fstream>
#include "NoCandidato.h"

class ListaCandidatos{
public:
    NoCandidato *head;

    ListaCandidatos();
    void adicioneComoHead(Candidato *c);
    bool estaVazia();
    int tamanho();
    string toString();
    ListaCandidatos(string nomeDoArquivo);
    bool remove(string nome, string sobrenome);
    void filtrarCandidatos(int notaCorte);
    void concatena(ListaCandidatos *l);
};
ListaCandidatos::ListaCandidatos(){
    head = NULL;
}
void ListaCandidatos::adicioneComoHead(Candidato *c){
    head = new NoCandidato(c, head);
}
bool ListaCandidatos::estaVazia(){
    return (head==NULL);
}
int ListaCandidatos::tamanho(){
    if(estaVazia()){
        cout<<"Numero de nos da lista: 0"<<endl;
        return 0;
    }
    NoCandidato *aux = head;
    int tam=0;
    while(aux != NULL){
        aux = aux->next;
        tam++;
    }
    //cout<<"Numero de nos da lista pppp: "<<tam<<endl;
    return tam;
}
string ListaCandidatos::toString(){
    if(estaVazia()){
        cout<<"A lista esta sem elementos"<<endl;
        return "0";
    }else{
        return head->toString();
    }
}
ListaCandidatos::ListaCandidatos(string nomeDoArquivo){
  head = NULL;

  ifstream fcin(nomeDoArquivo.c_str());

  string dados;
  getline(fcin,dados);
  //cout << "nome da regiao: " << dados << endl;

  while(getline(fcin,dados)){

    Candidato *c = new Candidato(dados);
    //cout << "criacao do candidato: " << c.toString( << endl;
    this->adicioneComoHead(c);
  }
}
bool ListaCandidatos::remove(string nome, string sobrenome){

    NoCandidato *aux;
    NoCandidato *it = head;
    if(estaVazia()){
       cout<<"A lista nao tem elementos"<<endl;
       return false;
    }
    if(it->conteudo->igual(nome, sobrenome)){
        aux = it;
        it = it->next;
        head = it;
        delete(aux);
        //cout<<"O candidato foi removido"<<endl;
        return true;
    }
    if(tamanho()>=2){
        while(it->next != NULL){
            if(it->next->conteudo->igual(nome, sobrenome)){
                aux = it->next;
                it->next = it->next->next;
                delete(aux);
                //cout<<"O Candidato foi removido"<<endl;
                return true;
            }
            it = it->next;
        }
    }
    return false;
}
void ListaCandidatos::filtrarCandidatos(int notaCorte){
    NoCandidato *aux;
    NoCandidato *it = head;

    do{
       if(it->conteudo->nota < notaCorte){
            aux = it;
            it = it->next;
            remove(aux->conteudo->nome, aux->conteudo->sobrenome);
       }else{
           it = it->next;
       }
    }while(it != NULL);
}
void ListaCandidatos::concatena(ListaCandidatos *l){
    NoCandidato *aux = head;
    while(aux->next != NULL){
        aux = aux->next;
    }
    aux->next = l->head;
}


#endif // LISTACANDIDATOS_H_INCLUDED
