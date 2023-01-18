package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent {
   SuperHeroesAppTheme {
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
     HeroeApp()
    }
   }
  }
 }
}

@Composable
fun HeroeApp() {
 Scaffold(
  topBar = {
   HeroTopAppBar();
  },
 ) {
  HeroeList();
 }
}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
 Card(
  modifier = Modifier.fillMaxSize(),
  elevation = 2.dp
 ) {
  Row(
   horizontalArrangement = Arrangement.SpaceAround
  ) {
   Column(
    modifier = Modifier
     .width(300.dp)
     .padding(16.dp)
   ) {
    Text(
     text = stringResource(id = hero.nameRes),
     style = MaterialTheme.typography.h3
    );
    Text(
     text = stringResource(id = hero.descriptionRes),
     style = MaterialTheme.typography.body1
    )
   }
   Image(
    painter = painterResource(id = hero.imageRes),
    contentDescription = null,
    modifier = Modifier
     .size(80.dp)
     .padding(4.dp)
     .clip(RoundedCornerShape(8.dp)),
    contentScale = ContentScale.Crop
//    modifier = Modifier.size(100.dp)
   )
  }
 }
 Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun HeroeList() {
 LazyColumn(
  modifier = Modifier.fillMaxSize().padding(8.dp)
 ) {
  items(heroes) { hero ->
   HeroCard(hero);
  }
 }
}

@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier) {
 Row(
  modifier = modifier.fillMaxWidth().height(56.dp),
  horizontalArrangement = Arrangement.Center

 ) {
  Text(
   text = "Superheroes",
   style = MaterialTheme.typography.h1,
  )
 }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
 SuperHeroesAppTheme {
  HeroeApp()
 }
}