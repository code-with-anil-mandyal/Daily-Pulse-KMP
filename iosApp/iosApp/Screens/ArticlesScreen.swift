//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Anil Kumar on 19/06/26.
//

import SwiftUI
import SharedLogic

extension ArticlesScreen {
    
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel
        
        @Published var articleState: ArticleState
        
        init() {
            
            articlesViewModel = ArticlesViewModel()
            
            articleState = articlesViewModel.articleState.value
        }
        
       
        
        func startObserving(){
            Task {
                for await articleS in articlesViewModel.articleState {
                    self.articleState = articleS
                }
            }
        }
        
    }
}

struct ArticlesScreen: View {
    
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View {
        VStack {
            AppBar()
            
        
            
            if viewModel.articleState.loading {
                Loader()
            }
            
            if let error = viewModel.articleState.error {
                ErrorMessage(message: error)
            }
            
            if(!viewModel.articleState.articles.isEmpty){
                ScrollView {
                    LazyVStack(spacing: 10){
                        ForEach(viewModel.articleState.articles, id: \.self) { article in
                            
                            ArticlesItemView(article: article)
                            
                        }
                    }
                }
            }
        }.onAppear{
            self.viewModel.startObserving()
        }
    }
}

struct ArticlesItemView: View {
    
    var article: Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            AsyncImage(url: URL(string: article.imageUrl)) { phase in
                if phase.image != nil{
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            
            Text(article.title)
                .font(.title)
                .fontWeight(.bold)
            Text(article.desc)
            Text(article.date).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}

struct AppBar: View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String
    var body: some View {
        Text(message)
            .font(.title)
    }
}


