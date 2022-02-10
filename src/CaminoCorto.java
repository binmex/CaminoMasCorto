public class CaminoCorto {
    //metodo floyd determinar caminos

    public String allgoritmoFloyd(long[][] mAdy) {
        int vertices = mAdy.length;
        long matrizAdyacencia[][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String caminosAux[][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;

        //inicializando las matrices caminos y caminos auxiliares
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAux[i][j] = "";
            }
        }

        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;

                    //encontrando camino minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAux[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAux, caminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo;
                }

            }
        }
        //agregando camino minimo a cadena
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";
        }

        ////////////////////////////////////////////
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") irse por...(" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") irse por...(" + (i + 1) + ", " + caminos[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }
        return "La matriz de caminos mas cortos entre los diferentes vertices es: \n" + cadena + "" +
                "\nLos diferentes caminos mas cortos entrenertices son:\n" + caminitos;
    }

    private String caminosR(int i, int k, String[][] caminosAux, String caminoRecorrido) {
        if (caminosAux[i][k].equals("")) {
            return "";
        } else {
            //recursividad al millon
            caminoRecorrido += caminosR(i, Integer.parseInt(caminosAux[i][k].toString()), caminosAux, caminoRecorrido) + (Integer.parseInt(caminosAux[i][k].toString()) + 1) + ", ";
            return caminoRecorrido;
        }
    }

}
