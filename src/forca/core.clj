(ns forca.core
  (:gen-class))


(def total-de-vidas 6)

(defn perdeu [](print " você perdeu\n --->"))

(defn ganhou [](print " você ganhou\n --->"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra))

;verifica se a lista esta vazia
(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos)))

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn avalia-chute [chute vidas palavra acertos]
    (if (acertou? chute palavra)
        (jogo vidas palavra (conj acertos chute))
        (jogo (dec vidas) palavra acertos)
    )
)

(defn jogo [vidas palavra acertos]
    (if (=vidas 0)
        (perdeu)
        (if (acertou-a-palavra-toda? palavra acertos)
            (ganhou)
            (avalia-chute (le-letra!) vidas palavra acertos))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))






 
;(def numeros [1 2 3 4 5])
;(def carros [50000.0 60000.0])




;(defn breakingLines [](print "\n"))

; exercise to know if a letter is in conj palavra
;(def palavra #{"A" "L" "U" "R"})
;(contains? palavra "A")


;(map (fn [letra](contains? (str letra)))palavra)

;(map (fn [letra] (contains? (str letra)))palavra)
;(remove (fn [x] (= (rem x 2) 1)) numeros)

;filter list number < 2 or > 4 ;;; 1, 5
;(filter (fn [x](or (< x 2)(> x 4)))numeros)

;(require '[forca.core :as forca] :reload)


; (defn jogo [vidas]
;   (if (= vidas 0)
;    (perdeu)
;    (do
;      (print vidas)
;      (breakingLines)
;      (jogo (dec vidas)))))

; (defn fib[n]
;   (if (= n 0) 0
;     (if (= n 1) 1
;      (+ (fib (- n 1)) (fib (- n 2))))))

; (defn pow3
;   [x]
;   (* x
;     (Math/pow 2 x)))
