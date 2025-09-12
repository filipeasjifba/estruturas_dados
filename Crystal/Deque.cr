require "deque"

class Main
    puts "-----navegação------"
    nav = Deque(String).new
    
    nav.unshift("google.com")
    nav.unshift("youtube.com")
    nav.unshift("gov.br")
    
    puts "Histórico: #{nav}"
    puts "Mais recente: #{nav.first}"
    puts "Mais antigo: #{nav.last}"
    
    puts "voltando uma página e acessando outra"
    nav.shift
    nav.unshift("github.com")
    puts nav
        
    puts "\n-----fila única com prioridade------"
    fila = Deque(String).new

    fila.push("Ana")
    fila.push("José")
    fila.push("Maria")
    puts fila
    puts "Chegou uma gestante (Fernanda)"
    fila.unshift("Fernanda")
    puts fila

end
