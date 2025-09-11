# Tupla (tuple)

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
end

class Main
    vitoria_da_conquista = TuplaMetodos.new({-14.8648, -40.8369})
    anage = TuplaMetodos.new({"-14.5995", "-41.1337"})
    barra_do_choça = TuplaMetodos.new({-14.8641,-40.5591})
    planalto = TuplaMetodos.new({-14.6604, -40.4789})

    puts "-----Localizações-----"
    puts "Vitória da Conquista: latitude #{vitoria_da_conquista[0]}, longitude #{vitoria_da_conquista[1]}"
    puts "Anagé: latitude #{anage[0]}, longitude #{anage[1]}"
    puts "Barra do choça: latitude #{barra_do_choça[0]}, longitude #{barra_do_choça[1]}"
    puts "Planalto: latitude #{planalto[0]}, longitude #{planalto[1]}"
    
end
