package org.dieschnittstelle.ess.basics;


import org.dieschnittstelle.ess.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.ess.basics.annotations.StockItemProxyImpl;
import org.dieschnittstelle.ess.basics.reflection.ReflectedStockItemBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.dieschnittstelle.ess.utils.Utils.*;

public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {
			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * TODO BAS2
	 */
	private static void showAttributes(Object instance) {
		show("class is: " + instance.getClass());

		// TODO BAS2: create a string representation of instance by iterating
		//  over the object's attributes / fields as provided by its class
		//  and reading out the attribute values. The string representation
		//  will then be built from the field names and field values.
		//  Note that only read-access to fields via getters or direct access
		//  is required here.

		String className = instance.getClass().getSimpleName();
		String attributesString = Arrays.stream(instance.getClass().getDeclaredFields()).map( field -> {
			String name = field.getName();
			String getterName = ReflectedStockItemBuilder.getAccessorNameForField("get", name);
			try {
				Method getter = instance.getClass().getDeclaredMethod(getterName);
				String value = getter.invoke(instance).toString();
				return name + ":" + value + ", ";
			} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}).reduce("",  String::concat);

		show("{%s %s}", className, attributesString.substring(0, attributesString.length() - 2));

		// TODO BAS3: if the new @DisplayAs annotation is present on a field,
		//  the string representation will not use the field's name, but the name
		//  specified in the the annotation. Regardless of @DisplayAs being present
		//  or not, the field's value will be included in the string representation.
	}

}
