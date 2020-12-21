(defproject open-encyclopedia "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [duct/core "0.7.0"]
                 [cljs-ajax "0.8.1"]
                 [re-frame "1.1.1"]
                 [reagent "0.10.0"]
                 [clj-commons/secretary "1.2.4"]
                 [day8.re-frame/http-fx "0.2.1"]
                 [duct/compiler.sass "0.2.1"]
                 [duct/module.logging "0.4.0"]
                 [duct/module.web "0.7.1"]
                 [hydrogen/module.cljs "0.5.2"]
                 [hydrogen/module.core "0.2.1"]
                 [org.clojure/clojurescript "1.10.773"]]
  :plugins [[duct/lein-duct "0.12.1"]]
  :main ^:skip-aot open-encyclopedia.main
  :resource-paths ["resources" "target/resources" "target/resources/open-encyclopedia"]
  :prep-tasks     ["javac" "compile" ["run" ":duct/compiler"]]
  :middleware     [lein-duct.plugin/middleware]
  :profiles
  {:dev  [:project/dev :profiles/dev]
   :repl {:prep-tasks   ^:replace ["javac" "compile"]
          :dependencies [[cider/piggieback "0.4.0"]]
          :repl-options {:init-ns user, :nrepl-middleware [cider.piggieback/wrap-cljs-repl], :host "0.0.0.0", :port 4001}}
   :uberjar {:aot :all}
   :profiles/dev {}
   :project/dev  {:plugins [[jonase/eastwood "0.3.7"]
                            [lein-cljfmt "0.6.6"]]
                  :source-paths   ["dev/src"]
                  :resource-paths ["dev/resources"]
                  :dependencies   [[integrant/repl "0.3.1"]
                                   [eftest "0.5.7"]
                                   [kerodon "0.9.0"]
                                   [day8.re-frame/re-frame-10x "0.7.0"]]}})
