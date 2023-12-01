(ns app.components.ibm-cds.accordion.accordion)

(defn accordion [props body]
  [:cds-accordion props body])

(defn accordion-item [props body]
  [:cds-accordion-item props body])