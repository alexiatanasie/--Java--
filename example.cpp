#include <iostream>
#include<string.h>
#include<string>
using namespace std;

enum culoareSemafor {
    rosu=10,
    galben=13,
    verde=16,
};

union eticheta {
    short v1;
    int v2;
    long long v3;
};
struct Carte {
    int nrPagini;
    float pret;
    char titlu[21];
    char autor[21];
};
class TelefonMobil {
protected: string producator;
private: string model;
public: int nivelBaterie;

      void incarcat(int nivelIncarcare) {
          nivelBaterie += nivelIncarcare;

      }
};
int main()
{
    culoareSemafor c1 = culoareSemafor::galben;
    cout << c1<<endl;
    c1 = (culoareSemafor)16;
    cout << c1 << endl;

    cout << sizeof(eticheta) << endl;
    eticheta e1;
    e1.v3 = 9999999;
    cout << e1.v1 << " " << e1.v2 << " " << e1.v3;
    e1.v3 = 7;
    cout << endl;
    cout << e1.v1 << " " << e1.v2 << " " << e1.v3<<endl;
   
    cout << sizeof(Carte) << endl;
    Carte c;
    c.nrPagini=337;
    c.pret = 50.5;
    strcpy_s(c.titlu, "Labirintul");
    cout << c.titlu << " " << c.pret << endl;

    TelefonMobil telefonPersonal;
    TelefonMobil telefonServiciu;

    telefonPersonal.nivelBaterie = 20;
    telefonPersonal.incarcat(50);
    cout << telefonPersonal.nivelBaterie << endl;
}

