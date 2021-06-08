// Example program
#include <iostream>
#include <string>
#include <cstdlib>
#include <array>

using namespace std;

const int PARADAS_POR_VUELTA = 20;
const int EMPIEZA_JORNADA = 6;
const int FIN_JORNADA = 24;
const int AFORO = 50;

typedef struct {
  int numSuben;
  int numBajan;
  int numTotal;
} TSPasajeros;

typedef struct {
    int minutos;
    int segundos;
} TSTiempo;

typedef struct {
  TSPasajeros pasajeros;
  TSTiempo enMarcha;
} TSAutobus;

typedef array <TSAutobus, PARADAS_POR_VUELTA> TABusParadas;

int getRand(int min, int max) {
    return (rand() % (max+1 - min)) + min;   
}

void tratarPasajeros(TSAutobus &autobus) {
    int numPasajerosSuben = getRand(0,15);
    int numPasajerosBajan = getRand(0,15);
    int numPasajerosTotal = numPasajerosSuben - numPasajerosBajan;
    
    if(autobus.pasajeros.numTotal + numPasajerosTotal < 0) {    
        numPasajerosBajan += autobus.pasajeros.numTotal + numPasajerosTotal;
        autobus.pasajeros.numTotal = 0;
        
    } else if (autobus.pasajeros.numTotal + numPasajerosTotal > AFORO) {
        autobus.pasajeros.numTotal = AFORO;
        numPasajerosSuben -= ((autobus.pasajeros.numTotal + numPasajerosTotal) - AFORO);
    } else {
        autobus.pasajeros.numTotal += numPasajerosTotal;
    }
    
    autobus.pasajeros.numSuben = numPasajerosSuben;
    autobus.pasajeros.numBajan = numPasajerosBajan;
}

void tratarTiempoParada(TSAutobus &autobus) {
    int tiempoSubir = autobus.pasajeros.numSuben * 8;
    int tiempoBajar = autobus.pasajeros.numBajan * 3;
    int tiempoTotal = max(tiempoSubir, tiempoBajar);
    autobus.enMarcha.segundos = tiempoTotal % 60;
    autobus.enMarcha.minutos = tiempoTotal / 60;
}

void parar(TSAutobus &autobus) {
    tratarPasajeros(autobus);
    tratarTiempoParada(autobus);
}

void imprimeEnPantalla(const TSAutobus &autobus) {
    cout << "===============  PARADA  ===============" << endl;
    cout << "AFORO --------" << endl;
    cout << "Suben: " << autobus.pasajeros.numSuben << endl;
    cout << "Bajan: " << autobus.pasajeros.numBajan << endl;
    cout << "En autobus: " << autobus.pasajeros.numTotal << endl;
    cout << endl << "TIEMPO --------" << endl;
    cout << "Minutos: " << autobus.enMarcha.minutos << endl;
    cout << "Segundos: " << autobus.enMarcha.segundos << endl;
    cout << "----------------------------------------" << endl;
}

int main()
{
  TSAutobus autobus = {{0,0,10}, {0,0}};
  
  for(int i = 0; i < 15; ++i) {
      parar(autobus);
      imprimeEnPantalla(autobus);
  }
  
  return 0;
}
