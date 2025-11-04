# Por não ser nativo, tivemos que importar uma biblioteca
require "deque"

class Main
    pedidos = Deque(String).new # Lembrando que o deque só recebe um tipo
    loop do
      puts "\n-----SISTEMA DA LANCHONETE DO IFBA-----"
        puts "1 - Novo pedido (push)"
        puts "2 - Pedido prioritário (unshift)"
        puts "3 - Atender pedido (shift)"
        puts "4 - Cancelar último pedido (pop)"
        puts "5 - Ver o primeiro pedido (first)"
        puts "6 - Ver último pedido (last)"
        puts "7 - Ver quantos pedidos estão na fila (size)"
        puts "8 - Limpar todos os pedidos (clear)"
        puts "9 - Mostrar fila completa (to_a)"
        puts "0 - Sair"
        print "Escolha uma opção:" # usamos print só nesse aqui, porque puts quebra linha
        opcao = gets.to_s.chomp

        #Fizemos verificações para evitar exceções
        case opcao
        when "1"
            print "Digite o pedido: "
            p = gets.to_s.chomp
            pedidos.push(p)
            puts "Pedido adicionado na fila: #{p}"
        when "2"
            print "Digite o pedido prioritário: "
            p = gets.to_s.chomp
            pedidos.unshift(p)
            puts "Pedido prioritário adicionado no início da fila: #{p}"
        when "3"
            if pedidos.empty?
                puts "Nenhum pedido para atender"
            else
                atendido = pedidos.shift
                puts "Pedido atendido: #{atendido}"
            end
        when "4"
            if pedidos.empty?
                puts "Nenhum pedido para cancelar"
            else
                cancelado = pedidos.pop
                puts "pedido cancelado: #{cancelado}"
            end
        when "5"
            if pedidos.empty?
                puts "Nenhum pedido na fila"
            else
                primeiro = pedidos.first
                puts "primeiro pedido da fila: #{primeiro}"
            end
        when "6"
            if pedidos.empty?
                puts "Nenhum pedido na fila"
            else
                ultimo = pedidos.last
                puts "último pedido da fila: #{ultimo}"
            end
        when "7"
            puts "Total de pedidos na fila: #{pedidos.size}"
        when "8"
            pedidos.clear
            puts "Todos os pedidos foram removidos"
        when "9"
            puts "Fila completa de pedidos: #{pedidos.to_a}"
        when "0"
            puts "Fechando sistema.."
            break
        else
            puts "Opção inválida, papai"
        end
    end
end
