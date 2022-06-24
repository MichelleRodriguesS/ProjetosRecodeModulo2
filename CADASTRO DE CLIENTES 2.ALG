Algoritmo "Cadastro de clientes Agencia de Viagens"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Flávio Mota
// Descrição   : Um cadastro de clientes e destinos que permite consulta, feito com vetores.
// Autor(a)    : Michelle Rodrigues da Silva Sales
// Data atual  : 18/06/2022
Var
   cliente: vetor  [1..10]  de caractere
   destino: vetor [1.. 10] de caractere
   datanasc: vetor [1..10] de inteiro
   Cont: inteiro
   contt:inteiro
   opcaoEscolha: inteiro
   z,x,y,k : inteiro


Inicio

   Enquanto verdadeiro faça // repete o menu //


      escreval ("                                ")
      Escreval (" Olá!")
      escreval ("---------------------------------")
      escreval (" ----------  MENU ---------------")
      escreval (" Para cadastrar clientes digite 1")
      escreval (" Para cadastrar destinos digite 2")
      escreval (" Para Consultar clientes digite 3")
      escreval (" Para Consultar destinos digite 4")
      escreval (" Para SAIR pressione a tecla ESC ")
      escreval ("---------------------------------")
      escreval ("---------------------------------")
      escreval ("                                 ")

      leia(opcaoEscolha)
      escolha opcaoEscolha
      caso 1
         Escreval ("Quantos clientes deseja cadastrar")
         leia(cont)  //armezana quantidade.//
         limpatela
         para z de 1 até cont faça
         // repete o leia  e armezana o nome do cliente;//
         //quantas vezes foi solicitada pelo usuário//
            escreval(" Digite o nome do cliente: ")
            leia(cliente[z])
            escreval ("Digite a data de nascimento do cliente: ")
            leia (datanasc[z])
         fimpara

         para x de 1 até cont faça
            escreval(" Cliente:  ", cliente[x])
            escreval ("Data de nascimento:   " ,datanasc[x])

         fimpara



      caso 2
         Escreval ("Quantos destinos deseja cadastrar?")
         leia(contt)
         limpatela
         para y de 1 até contt faça
            escreval(" Digite o destino: ")
            leia(destino[y])
         fimpara
         limpatela


      caso 3
         para x de 1 até cont faça
            escreval(" Cliente:  ", cliente[x])
            escreval ("Data de nascimento:   " ,datanasc[x])

         fimpara


      caso 4
         para k de 1 até contt faça
            escreval ("Destino adicionado:  " ,destino[k])
         fimpara


      fimpara

   fimescolha
fimenquanto
Fimalgoritmo
