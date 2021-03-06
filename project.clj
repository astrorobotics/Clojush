(defproject lspector/clojush "1.2.40"
            :description "The Push programming language and the PushGP genetic programming
                          system implemented in Clojure.
                          See http://hampshire.edu/lspector/push.html"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [org.clojure/math.numeric-tower "0.0.1"]
                           [cosmos/cosmos "1.0.0-SNAPSHOT"]
                           [local-file "0.0.4"]
                           [clojure-csv "2.0.0-alpha2"]
                           [org.clojure/data.json "0.1.3"]]
            :dev-dependencies [[lein-ccw "1.2.0"]]
            :main clojush.core)
