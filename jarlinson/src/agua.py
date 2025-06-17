clientes=0
total_ganado=0
respuesta = 's'
while (respuesta == 's') or (respuesta == 'S'):
    tipo = int(input("Escriba su tipo de estacionamiento:"))
    hora = int(input("Escriba las horas:"))

    if tipo== 1:
        precio= 20 * hora
    else:
        if tipo== 2:
            precio= 15 * hora
        else:
            if tipo== 3:
                precio= 10 * hora
            else:
                precio= 0
                print("El valor asignado es incorrecto.")

    colonia = int(input("Colonia en la que se encuentra: "))

    if colonia== 1:
        valor= 50
    else:
        if colonia== 2:
            valor= 30
        else:
            if colonia== 3:
                valor= 20
            else:
                valor= 0
                print("El valor asignado es incorrecto.")

    if (hora < 3):
        descuento= 0
        print("No tiene un descuento")
    else:
        if (hora >= 3) and (hora <= 5):
            descuento= 0.02
        else:
            if hora > 5:
                descuento= 0.05

    pago_estacionamiento = precio
    desc = (precio + valor) * descuento
    total_pagar = precio + valor - desc

    print("El pago por estacionamiento:", pago_estacionamiento)
    print("El descuento es:", desc)
    print("El total a pagar es:", total_pagar)
    clientes=clientes+1
    total_ganado=total_ganado+total_pagar
    print("el numero de clentes fue:",clientes)
    print("el total que gano la empresa fue:",total_ganado)

    respuesta = input("¿Desea continuar? (s/n):")