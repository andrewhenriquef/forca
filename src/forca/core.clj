(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [](print " você perdeu\n --->"))
(defn ganhou [](print " você ganhou\n --->"))

(defn breakingLines [](print "\n"))

(defn acertou-a-palavra-toda? [palavra acertos] true)

(defn jogo [vidas palavra acertos]
 (if (= vidas 0)
  (perdeu)
  (if (acertou-a-palavra-toda? palavra acertos)
      (ganhou)
      (print "Chuta, amigo!"))))


; (defn jogo [vidas]
;   (if (= vidas 0)
;    (perdeu)
;    (do
;      (print vidas)
;      (breakingLines)
;      (jogo (dec vidas)))))

(defn fib[n]
  (if (= n 0) 0
    (if (= n 1) 1
     (+ (fib (- n 1)) (fib (- n 2))))))

(defn pow3
  [x]
  (* x
    (Math/pow 2 x)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
