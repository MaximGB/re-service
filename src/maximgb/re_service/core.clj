(ns maximgb.re-service.core
  {:author "Maxim Bazhenov"})


(defmacro def-re-service
  "Defines a service with the given `service-id`."
  [service-id]
  `(register-service ~service-id))


(defmacro def-re-service-command
  "Defines a command with the given `command-id` for service designated by `service-id`.

   Command recieves set of arguments defined in `args` vector and is implemented by given `fn-body`.
   If command is invoked during co-effect injection then the first argument will be co-effects map."
  [service-id command-id args & fn-body]
  `(register-service-command ~service-id
                             ~command-id
                             (fn ~args ~@fn-body)))


(defmacro def-re-service-command-raw
  "Defines a raw service command.

  Command recieves set of arguments defined in `args` vector and is implemented by given `fn-body`.
  The difference from `(def-service-command)` is that `service-id` `command-id` will be passed
  as the first and the second arguments in the `args` vector."
  [service-id command-id args & fn-body]
  `(register-service-command-raw ~service-id
                                 ~command-id
                                 (fn ~args ~@fn-body)))
