# Classe TuplaMetodos

class TuplaMetodos(T)

    def initialize(tuple : T)
        @tuple = tuple
    end

    # Na tupla, a estrutura só está vazia se for criada sem campo
    def empty?
        @tuple.size == 0
    end

    # No caso da tupla, fiz este método só para explicar, pois se não estiver vazia, sempre estará cheia
    def full?
        @tuple.size > 0
    end

    def size
        @tuple.size
    end
    
    def [](index)
        @tuple[index]
    end

    # Não há tantos métodos pois a tupla é imutável
end

#Classe main

class Main

    minha_tupla = TuplaMetodos.new({"Claudio", 18, "Rodolfo", 30})
    puts "A tupla está vazia? #{minha_tupla.empty?}"
    puts "A tupla está cheia? #{minha_tupla.full?}"
    puts "o tamanho da tupla é: #{minha_tupla.size} objetos"
    p "Exemplo: A aula do professor #{minha_tupla[0]} #{minha_tupla[2]} acontece na segunda às #{minha_tupla[1]}:#{minha_tupla[3]}"

end