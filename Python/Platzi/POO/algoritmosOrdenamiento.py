import random, time


def ordenamiento_de_burbuja(lista):
    n = len(lista)

    for i in range (n):
        for j in range (0,(n-i-1)):

            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]

    return lista


def ordenamiento_por_insercion(lista):
    lista_ordenada = []
    lista_ordenada.append(lista[0])
    n = len(lista)

    for i in range(lista[1], n):
        pass


def ordenamiento_por_mezcla(lista):
    if len(lista) > 1:
        medio = len(lista) // 2
        izquierda = lista[:medio]
        derecha = lista[medio:]

        # Llamada recursiva a cada mitad
        ordenamiento_por_mezcla(izquierda)
        ordenamiento_por_mezcla(derecha)

        # Iteradores para recorrer cada sublista
        i = 0
        j = 0

        # Iterador para la lista principal
        k = 0

        while i < len(izquierda) and j < len(derecha):
            if izquierda[i] < derecha[j]:
                lista[k] = izquierda[i]
                i += 1
            else:
                lista[k] = derecha[j]
                j += 1

            k += 1
        
        while i < len(izquierda):
            lista[k] = izquierda[i]
            i += 1
            k += 1
        
        while j < len(derecha):
            lista[k] = derecha[j]
            j += 1
            k += 1

    return lista

if __name__ == '__main__':
    tamano_de_lista = int(input('De que tamano sera la lista? '))

    lista = [random.randint(0, 100) for i in range(tamano_de_lista)]

    print('')
    print("Lista Desordenada")
    print(lista)
    print('-' * 20)

    print('')
    print('Ordenamiento de Burbuja')
    comienzo = time.time()
    lista_ordenada = ordenamiento_de_burbuja(lista)
    final = time.time()
    print('Duracion: {}'.format(str(final - comienzo)))
    print(lista_ordenada)


    print('')
    print('Ordenamiento por Mezcla')
    comienzo = time.time()
    lista_ordenada = ordenamiento_por_mezcla(lista)
    final = time.time()
    print('Duracion: {}'.format(str(final - comienzo)))
    print(lista_ordenada)

