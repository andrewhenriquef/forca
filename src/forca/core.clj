(ns forca.core
  (:gen-class))

(def total-de-vidas 6)
(def palavra-secreta "MELE")

(defn perdeu [] (print "Você perdeu!"))

(defn ganhou [] (print "Você ganhou!"))

(defn le-letra! [] (read-line))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos)))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn imprime-forca [vidas palavra acertos]
  (println "Vidas " vidas)
  (doseq [letra (seq palavra)]
    (if (contains? acertos (str letra))
     (print letra " ")
     (print "_" " ")))
  (println))

(defn jogo [vidas palavra acertos]
    (imprime-forca vidas palavra acertos)
    (cond
      (= vidas 0)(perdeu)
      (acertou-a-palavra-toda? palavra acertos)(ganhou)
      :else
      (let [chute (le-letra!)]
        (if (acertou? chute palavra)
         (do
           (println "Acertou a letra !")
           (recur vidas palavra (conj acertos chute)))
         (do
            (println "Errou a letra !")
            (recur (dec vidas) palavra acertos))))))


(defn comeca-o-jogo [] (jogo 6 palavra-secreta #{}))

(defn -main [& args]
 (comeca-o-jogo))

;Listas
; (->> carros
;   (map (fn [x] (- x 200)))
;   (map (fn [x] (* x 2)))
;   (reduce (fn [acc n](+ acc n))))


;recursive fibonacci
; (defn fib[x]
;   (loop [a 1 b 1 numero 2]
;     (if (= numero x) b
;      (recur b (+ a b)(inc numero)))))

;Recursive sum
; (defn soma[n]
;    (loop [contador 1 soma 0]
;      (if (> contador n) soma
;       (recur (inc contador) (+ soma contador)))))