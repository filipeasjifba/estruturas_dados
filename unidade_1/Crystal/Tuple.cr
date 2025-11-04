# A tupla já é nativa do Crystal

class Main
    cidade = {"Vitória da Conquista", -14.8648, -40.8369, 340000, "https://desciclopedia.org/wiki/Vit%C3%B3ria_da_Conquista"}
    loop do
        puts "\n-----INFORMAÇÕES DA CIDADE-----"
        puts "1 - Ver nome da cidade (first ou [0])"
        puts "2 - Ver coordenadas ([1][2])"
        puts "3 - Ver população ([3])"
        puts "4 - Descobrir mais da cidade (last ou [4])😏"
        puts "5 - Quantos dados tem a tupla (size)"
        puts "0 - sair"
        print "Escolha uma opção: "
        opcao = gets.to_s.chomp

        case opcao
        when "1"
            puts "Nome da cidade: #{cidade.first}"
        when "2"
            puts "Coordenadas: latitude #{cidade[1]}, longitude #{cidade[2]}"
        when "3"
            puts "População: #{cidade[3]} habitantes"
        when "4"
            puts "Acesse: #{cidade.last}"
        when "5"
            puts "A tupla tem #{cidade.size} dados"
        when "0"
            puts "Fechando o programa.."
            break
        else
            puts "Opção inválida, papai"
        end
    end
end
