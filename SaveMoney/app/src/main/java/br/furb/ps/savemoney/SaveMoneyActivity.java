package br.furb.ps.savemoney;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SaveMoneyActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	private ListView listaOfertas;
	private String userId;
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_money);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

		listaOfertas = (ListView) findViewById(R.id.listaOfertas);
	}

	@Override
	protected void onStart() {
		super.onStart();

		String id = getIntent().getStringExtra("_userId");
		userId = id;

		final String[] from = { "nome", "imagem" };
		final int[] to = { android.R.id.text1, android.R.id.text2 };
		final SimpleAdapter adapter = new SimpleAdapter(this, listarOfertas(),
				android.R.layout.simple_list_item_2, from, to);
		listaOfertas.setAdapter(adapter);
	}

	/**
	 * 
	 * TODO: Metodo tratara do acesso ao SQLite
	 * 
	 * @return
	 */
	private List<Map<String, String>> listarOfertas() {

		final List<Map<String, String>> dados = new ArrayList<Map<String, String>>();

		Map<String, String> rec = new HashMap<String, String>();
		rec.put("nome", "Alcatra");
		rec.put("imagem", "Image not found");
		dados.add(rec);

		rec = new HashMap<String, String>();
		rec.put("nome", "Cerveja Heineken");
		rec.put("imagem", "Image not found");
		dados.add(rec);

		rec = new HashMap<String, String>();
		rec.put("nome", "Caixa de Isopor");
		rec.put("imagem", "Image not found");
		dados.add(rec);

		rec = new HashMap<String, String>();
		rec.put("nome", "Grelha de Aco Inox");
		rec.put("imagem", "Image not found");
		dados.add(rec);

		return dados;
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.str_todas_ofertas);
			break;
		case 2:
			mTitle = getString(R.string.str_alimentos);
			break;
		case 3:
			mTitle = getString(R.string.str_bebidas);
			break;
		case 4:
			mTitle = getString(R.string.str_utensilios);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.save_money, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_save_money,
					container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((SaveMoneyActivity) activity).onSectionAttached(getArguments()
					.getInt(ARG_SECTION_NUMBER));
		}
	}

}
