import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testClass<K, V> {
	
	private BinarySearchTree<K,V> EnglishToSpanish;
	private BinarySearchTree<K,V> SpanishToFrench;
	private Translator<K,V> Translator;
	
	@Before
	public void setUp() {
		EnglishToSpanish = new BinarySearchTree<>();
		SpanishToFrench = new BinarySearchTree<>();
		Translator = new Translator<>();
		
		Association<K, V> Val1 = (Association<K, V>) new Association<String, String>("house", "casa");
		EnglishToSpanish.InsertRoot(Val1);
		
		Association<K, V> Val2 = (Association<K, V>) new Association<String, String>("casa", "loger");
		SpanishToFrench.InsertRoot(Val2);	
		
	}
	
	@Test
	public void EnglishToSpanishTreeRootCanBeInserted() {
		Object result = EnglishToSpanish.getRoot().getValue().getKey(); 
		assertEquals(result, "house");
	}
	
	@Test
	public void SpanishToFrenchTreeRootCanBeInserted() {
		Object result = SpanishToFrench.getRoot().getValue().getKey();
		assertEquals(result, "casa");
	}
	
	@Test
	public void SearchNotFoundReturnsNull() {
		Node<K, V> SearchResult = EnglishToSpanish.Search(EnglishToSpanish.getRoot(), "No");
		
		assertEquals(SearchResult, null);
	}
	
	@Test
	public void SearchFoundReturnsNodeWithAssociation() {
		Association<K, V> Val1 = (Association<K, V>) new Association<String, String>("yes", "si");
		Association<K, V> Val2 = (Association<K, V>) new Association<String, String>("dog", "perro");
		
		EnglishToSpanish.Insert(EnglishToSpanish.getRoot(), Val1);
		EnglishToSpanish.Insert(EnglishToSpanish.getRoot(), Val2);
		
		Node<K, V> SearchResult = EnglishToSpanish.Search(EnglishToSpanish.getRoot(), "DOG");
		
		assertEquals(SearchResult.getValue().getClass(), Val1.getClass());
	}
	
	@Test
	public void TranslationNotFoundReturnsSameWord() {
		String[] Sentence = {"My", "name", "is", "pedro"};
		String result = Translator.Translate(EnglishToSpanish, Sentence);

		assertEquals(result,"*My* *name* *is* *pedro*");
	}
	
	@Test
	public void TranslationFoundReturnsTransalatedWords() {
		String[] Sentence = {"My", "name", "is", "pedro", "hi"};
		Association<K, V> Val1 = (Association<K, V>) new Association<String, String>("hi", "hola");
		Association<K, V> Val2 = (Association<K, V>) new Association<String, String>("name", "nombre");
		
		EnglishToSpanish.Insert(EnglishToSpanish.getRoot(), Val1);
		EnglishToSpanish.Insert(EnglishToSpanish.getRoot(), Val2);
		
		String result = Translator.Translate(EnglishToSpanish, Sentence);
		System.out.println(result);

		assertEquals(result,"*My* nombre *is* *pedro* hola");
	}

}
