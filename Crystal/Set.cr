# Set não é nativo, por isso temos que importar
require "set"

class Main
    convidados = Set(String).new
    
    loop do
        puts "\n-----LISTA DE CONVIDADOS-----"
        puts "1 - adicionar convidado (add)"
        puts "2 - testar duplicação (add de mesmo nome)"
        puts "3 - remover convidado (delete)"
        puts "4 - ver se o convidado está na lista (includes?)"
        puts "5 - ver quantos convidados tem (size)"
        puts "6 - limpar a lista (clear)"
        puts "7 - ver a lista completa (to_a)"
        puts "0 - sair"
        print "Escolha uma opção: "
        opcao = gets.to_s.chomp

        case opcao
        #Se você adicionar um convidado que já está na lista, ele não duplica
        when "1"
            print "Nome do convidado: "
            nome = gets.to_s.chomp.downcase
            convidados.add(nome)
            puts "Convidado adicionado: #{nome}"
        when "2"
            puts "Lista do momento: #{convidados.to_a}"
            print "Nome do convidado: "
            nome = gets.to_s.chomp.downcase
            convidados.add(nome)
            puts "Lista agora: #{convidados.to_a}"
        when "3"
            if convidados.empty?
                puts "Nenhum convidado para tirar"
            else
                print "Nome do convidado a ser removido: "
                nome = gets.to_s.chomp.downcase
                if convidados.includes?(nome)
                    convidados.delete(nome)
                    puts "o convidado #{nome} foi tirado da lista"
                else
                    puts "Esse convidado não existe na lista"
                end
            end
        when "4"
            print "digite o nome da pessoa:"
            nome = gets.to_s.chomp.downcase
            if convidados.includes?(nome)
                puts "Sim, #{nome} está na lista de convidados"
            else
                puts "Não, você esqueceu ou ignorou #{nome}"
            end
        when "5"
            puts "Sua lista já tem #{convidados.size} convidados"
        when "6"
            if convidados.empty?
                puts "Vai tirar quem, se não tem ninguém?"
            else
                convidados.clear
                puts "Todo mundo foi removido da sua lista"
            end
        when "7"
            puts "Lista completa de convdados #{convidados.to_a}"
        when "0"
            puts "Fechando programa.."
            break
        else
            puts "Opção inválida, papai"
        end
    end
end
