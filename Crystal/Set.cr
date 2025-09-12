require "set"

s = Set{1,2,3}

class Main
    lista_de_convidados = Set{"Leo", "Aline", "Cláudio", "Alexandro", "Leo", "Liojes", "Viviane", "Cláudio"}
    puts lista_de_convidados

    emails_bd = Set{"a@gmail.com", "b@gmail.com", "c@gmail.com", "c@gmail.com", "d@gmail.com"}
    emails_bd.add("b@gmail.com")
    emails_bd.delete("c@gmail.com")
    puts emails_bd
end
