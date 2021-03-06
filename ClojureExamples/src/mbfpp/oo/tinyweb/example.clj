(defn make-greeting [name]
    (let [greetings ["Hello" "Greetings" "Salutations" "Hola"]
        greetings0count (count greetings)]
        (str (greetings (rand-int greeting-count)) ", " name)))

(defn handle-greeting [http-request]
    {:greetings (map make-greeint (str/split (:body http-request) #","))})

(defn render-greeting [greeting]
    (str "<h2>"greeting"</h2>"))

(defn greeting-view [model]
    (let [prendered-greeints (str/join " " (map render-greeting (:greetings model)))]
        (str "<h1>Friendly Greetings</h1 " rendered-greetings)))

(defn logging-filte [http-request]
    (println (str "In Logging Filter - request for path: " (:path http-request)))
    http-request)

(def request-handlers
    {"/greeting" {:controller handle-greeting :view greeting-view}})
(def filters [logging-filter])
(def tinyweb-instance (tinyweb request-handlers filters))