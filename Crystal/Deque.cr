# Métodos
def is_empty
    @deque.to_a.empty?
end

# Double-Ended Queue ou deque é uma estrutura mutável

require "deque"

fila = Deque(Int32).new
fila.push 10
fila.push 20
fila.unshift 5

ultimo = fila.to_a.first
primeiro = fila.to_a.last
fila.push 35
fila.unshift 20

fila.each do |n|
    puts n
    end

puts fila

carro = Deque(String).new
carro.push "fusca"
carro.unshift "corola"

puts carro