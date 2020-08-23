import random
import math as m


def busqueda_lineal(lista, objetivo):
    match = False

    for elemento in lista: # O(n) Complejidad lineal (crecimiento proporcional a input)
        if elemento == objetivo:
            match = True
            break

    return match


def busqueda_binaria(lista_o, comienzo, final, objetivo):
    if comienzo > final:
        return False

    medio = m.floor((comienzo + final) / 2)

    if lista_o[medio] == objetivo:
        return True
    elif lista_o[medio] < objetivo:
        return busqueda_binaria (lista_o, (medio + 1), final, objetivo)
    else:
        return busqueda_binaria (lista_o, comienzo, (medio - 1), objetivo)


if __name__ == '__main__':
    tipo_de_busqueda = input('Por favor indique el tipo de busqueda, (L)ineal o (B)inaria: ')
    tipo_de_busqueda = tipo_de_busqueda.upper()

    tamano_de_lista = int(input('De que tamano sera la lista? '))
    objetivo = int(input('Que numero quieres encontrar? '))

    lista = [random.randint(0, 100) for i in range(tamano_de_lista)]

    if tipo_de_busqueda == 'L':
        print(lista)
        resultado = busqueda_lineal(lista, objetivo)
        print(f'El elemento {objetivo} {"esta" if resultado else "no esta"} en la lista')
    elif tipo_de_busqueda == 'B':
        lista_o = sorted(lista)
        print(lista_o)
        resultado = busqueda_binaria(lista_o, 0, (len(lista_o) - 1), objetivo)
        print(f'El elemento {objetivo} {"esta" if resultado else "no esta"} en la lista')
    else:
        print('Opcion incorrecta')

