"""Ficha 4"""

print("\n-----\nFicha 4\n-----\n")

print("\n-----\nEx 4.1\n")
def conta_letras(txt):
    contaLetras=0
    for i in txt:
        if i.isalpha():
            contaLetras+=1
    return contaLetras

print("'Ola, mundo!', tem "+str(conta_letras('Ola, mundo!'))+" letras.")

print("\n")

print("\n-----\nEx 4.2\n")
def apenas_letras(txt):
    letras=True
    for i in txt:
        if not i.isalpha():
            letras=False
            break
    return letras

print("'Abracadabra', tem só letras? "+str(apenas_letras('Abracadabra')))
print("'Ola, mundo!', tem só letras? "+str(apenas_letras('Ola, mundo!')))

print("\n")

print("\n-----\nEx 4.3\n")
def filtra_letras(txt):
    soLetras=""
    for i in txt:
        if i.isalpha():
            soLetras+=i
    return soLetras

print("'Ola!, -- disse ele...', tem estas letras "+filtra_letras('Ola!, -- disse ele...'))

print("\n")

print("\n-----\nEx 4.4\n")
def inversa(txt):
    invertido=""
    for i in txt:
        invertido=i+invertido
    return invertido

print("'Ola Mundo!', invertido é "+inversa('Ola Mundo!'))

print("\n")

print("\n-----\nEx 4.5\n")
def palindromo(txt):
    original=txt.lower()
    invertido=""
    for i in original:
        invertido=i+invertido
    return original==invertido

print("'reviveR' é palíndromo? "+str(palindromo('reviveR')))

print("\n")

print("\n-----\nEx 4.6\n")
def filtra_letras2(txt):
    soLetras=""
    for i in txt:
        if i.isalpha():
            soLetras+=i
    return soLetras

def palindromo2(txt):
    original=txt.lower()
    invertido=""
    for i in original:
        invertido=i+invertido
    return original==invertido

print("'Amora me tem aroma.' é palíndromo? "+str(palindromo2(filtra_letras2('Amora me tem aroma.'))))
print("'Madam, I\'m Adam.' é palíndromo? "+str(palindromo2(filtra_letras2('Madam, I\'m Adam.'))))
print("'A man, a plan, a canal: Panama' é palíndromo? "+str(palindromo2(filtra_letras2('A man, a plan, a canal: Panama'))))

print("\n")

print("\n-----\nEx 4.7\n")
def rem_espacos(txt):
    espacos=0
    string=""
    for i in txt:
        if i.isalpha():
            string+=i
            espacos=0
        elif not i.isalpha() and i!=" ":
            string+=i
            espacos=0
        else:
            if i==" " and espacos<1:
                string+=i
                espacos+=1
            else:
                continue
    return string

print("'Ola,   Mundo   !' com os espaços corrigidos: "+rem_espacos('Ola,   Mundo   !'))

print("\n")

print("\n-----\nEx 4.8\n")
def forte(passwd):
    if len(passwd)<8:
        return False
    
    Mai=False
    Min=False
    Num=False

    for i in passwd:
        if i.isupper():
            Mai=True
        elif i.islower():
            Min=True
        elif i.isdigit():
            Num=True

    return Mai and Min and Num

print("'9EwL56' é password forte? "+str(forte('9EwL56')))
print("'HXKW1393' é password forte? "+str(forte('HXKW1393')))
print("'ffu4G7Fghjk' é password forte? "+str(forte('ffu4G7Fghjk')))

print("\n")

print("\n-----\nEx 4.9\n")
def rem_vogais(txt):
    vogais='aeiouAEIOU'
    semVogais=""
    for i in txt:
        if i not in vogais:
            semVogais+=i
    return semVogais

print("'Abracadabra!', sem as vogais: "+rem_vogais('Abracadabra!'))

print("\n")

print("\n-----\nEx 4.10\n")
""" super difícil, ChatGPT ajudou bastante neste"""
def vigenere(chave, txt):
    textoCifrado=""
    cifra=(len(txt) // len(chave))*chave + chave[:len(txt) % len(chave)] # cifra = 4*chave (ver slide 5 da Teórica 6) + 1(resto da chave)*chave (ver slide 9 da Teórica 6 txt[:j])
    for i in range(len(txt)):
        txtAscii = ord(txt[i]) # converte o caractere da posição i no texto original no seu equivalente código ASCII e guarda o valor
        cifraAscii = ord(cifra[i%len(chave)]) # converte o caractere da posição i na cifra no seu equivalente código ASCII e guarda o valor
        letraCifrada = chr((txtAscii + cifraAscii) % 26 + ord('A')) # Cifrar a letra na posição i (ver slide 26 da Teórica 6 rodar(k, c) em que k=txtAscii e n=cifraAscii)
        """
        (txtAscii + cifraAscii) - representa o deslocamento
        % 26 - garante que a letra fica dentro do intervalo (alfabeto tem 26 letras)
        + ord('A') - soma o valor ASCII da letra A para que a resposta saia com letras maiusculas
        chr(...) - volta a converter os códigos numa letra
        """
        textoCifrado+=letraCifrada # guarda as letras cifradas por ordem para serem devolvidas na resposta
    return textoCifrado

print("'ATAQUEDEMADRUGADA', é cifrado para: "+vigenere('LUAR','ATAQUEDEMADRUGADA'))

print("\n")
