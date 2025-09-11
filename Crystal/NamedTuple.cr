# Tupla nomeada (NamedTuple)

class NamedTupleMetodos(T)

    def initialize(namedTuple : T)
        @namedTuple = namedTuple
    end

    def empty?
        @namedTuple.size==0
    end

    def full?
        !empty?
    end

    def size
        @namedTuple.size
    end

    def [](chave : Symbol)
        @namedTuple[chave]
    end
end

class Main
    dados_climáticos = NamedTupleMetodos.new({city: "Vitória da Conquista", temperatura: 29.9, umidade: 70, velocidade_vento: 15.2})
    puts "Condição do tempo em #{dados_climáticos[:city]}: \ntemperatura: #{dados_climáticos[:temperatura]}\numidade: #{dados_climáticos[:umidade]}\nvelocidade do vento: #{dados_climáticos[:velocidade_vento]}"
end
