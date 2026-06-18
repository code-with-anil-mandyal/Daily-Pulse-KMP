//
//  AboutScreen.swift
//  iosApp
//
//  Created by Anil Kumar on 18/06/26.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle("About Device")
        }
    }
}

#Preview {
    AboutScreen()
}
