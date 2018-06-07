(ns mbfpp.oo.tinyweb.steptwo
    (:import (com.mblinn.oo.tinyweb RenderingExcetpion)))

(defn test-controller [htpp-request]
    {:name (http-request :body)})

(defn test-view [model]
    (str "<h1>Hello, " (model :name) "</h1>"))

(defn- render [view model]
    (try
        (view model)
        (catch Exception e (throw (RenderingException. e)))))