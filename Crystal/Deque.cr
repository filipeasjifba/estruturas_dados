# Fila dupla (Deque ou Double Ended Queue)

require "deque"
class MinhaDeque(T)
  def initialize
    @deque = Deque(T).new
  end

  def empty?
    @deque.empty?
  end

  def push(value : T)
    @deque.push(value)
  end

  def unshift(value : T)
    @deque.unshift(value)
  end

  def pop
    @deque.pop
  end

  def shift
    @deque.shift
  end

  def first
    @deque.first
  end

  def last
    @deque.last
  end

  def size
    @deque.size
  end

  def to_s(io)
    io << @deque.to_a
  end
end

class Main
    fila = MinhaDeque(Int32).new
    fila.push 10
    fila.push 20
    fila.unshift 7

    puts fila
    puts "Primeiro: #{fila.first}"
    puts "Último: #{fila.last}"
    ultimo = fila.pop
    primeiro = fila.shift

    fila.push 35
    fila.unshift 20

    puts "Fila final: #{fila}"

    carro = MinhaDeque(String).new
    carro.push "fusca"
    carro.unshift "corolla"

    puts "Carros: #{carro}"
end
