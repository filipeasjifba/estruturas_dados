# A tupla já é nativa do Crystal

class Main
    vitoria_da_conquista = {-14.8648, -40.8369}
    anage = {"-14.5995", "-41.1337"}
    barra_do_choça ={-14.8641,-40.5591}
    planalto = {-14.6604, -40.4789}

    puts "-----Localizações-----"
    puts "Vitória da Conquista: latitude #{vitoria_da_conquista[0]}, longitude #{vitoria_da_conquista[1]}"
    puts "Anagé: latitude #{anage[0]}, longitude #{anage[1]}"
    puts "Barra do choça: latitude #{barra_do_choça[0]}, longitude #{barra_do_choça[1]}"
    puts "Planalto: latitude #{planalto[0]}, longitude #{planalto[1]}"
    
    acesso = {"user", "user123"}
    puts "\n------Acesso a dados para API----------"
    puts "> Usuário: #{acesso[0]}"    
    puts "> Senha: #{acesso[1]}"
    puts "Acesso concedido"
    
    # usando tupla nomeada
    dados_climáticos = {city: "Vitória da Conquista", temperatura: 29.9, umidade: 70, velocidade_vento: 15.2}
    puts "Condição do tempo em #{dados_climáticos[:city]}: \ntemperatura: #{dados_climáticos[:temperatura]}\numidade: #{dados_climáticos[:umidade]}\nvelocidade do vento: #{dados_climáticos[:velocidade_vento]}"
end
