# Classe NamedTupleMetodos

class NamedTupleMetodos(T)

    def initialize(namedTuple : T)
        @namedTuple = namedTuple
    end

    def empty?
        @namedTuple.size==0
    end

    def full?
        @namedTuple.size>0
    end

    def size
        @namedTuple.size
    end

    def []()
end

class Main

tupla_nomeada = NamedTupleMetodos.new({nome: "Filipe", idade:30, ativo: false})

puts tupla_nomeada.empty?

end