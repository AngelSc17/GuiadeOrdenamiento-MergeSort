public class Tienda {
    public static void main(String[] args) {
        String[][] productos = {
            {"Manzanas", "10.50", "50"},
            {"Naranjas", "12.25", "30"},
            {"Plátanos", "6.00", "40"},
            {"Peras", "9.00", "20"},
            {"Uvas", "3.50", "35"}
        };

        mergeSort(productos, 0, productos.length - 1);

        System.out.println("Lista de productos ordenada por nombre:");
        for (String[] producto : productos) {
            System.out.println(producto[0] + " - Precio: $" + producto[1] + " - Cantidad Disponible: " + producto[2]);
        }
    }

    public static void mergeSort(String[][] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(arr, inicio, medio);
            mergeSort(arr, medio + 1, fin);
            merge(arr, inicio, medio, fin);
        }
    }

    public static void merge(String[][] arr, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        String[][] izquierda = new String[n1][3];
        String[][] derecha = new String[n2][3];

        for (int i = 0; i < n1; i++) {
            izquierda[i] = arr[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            derecha[j] = arr[medio + 1 + j];
        }

        int i = 0, j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda[i][0].compareTo(derecha[j][0]) <= 0) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = derecha[j];
            j++;
            k++;
        }
    }
}
